function ExamDisplayController(examService,$location,loginService){

    var vm = this;
    vm.$onInit = $onInit;
    vm.getExambyId = getExambyId;
    vm.onSubmit = onSubmit;
    vm.ScoreNotEmpty = ScoreNotEmpty;
    vm.showError = showError;
    vm.redirect = redirect;

    function $onInit(){
        var test = $location.search();
        vm.QuestionList=[];
        loginService.SetHeaders(test.foo,test.fo);
        return loginService.verifyLink(test.foo,test.fo)
            .then(function test(response){
                vm.userDetails = response.data;
                    var test2 = vm.userDetails.examId;
                    vm.getExambyId(test2);
            });
    }

    function getExambyId(test2){
        return examService.display(test2)
            .then(function getExam(response){
                vm.getExam = response.data;
            })
    }


    function onSubmit(obj){
        console.log(obj);
        console.log((Object.keys(obj)));
        values = Object.values(obj);
        console.log(vm.getExam.questionResponseList[0].question.question_id);
        var n = vm.getExam.questionResponseList.length;

        for (i=0;i<n;i++){
            vm.QuestionList[i] = {question_id: null, correctChoice_id: null};
            vm.QuestionList[i].question_id = vm.getExam.questionResponseList[i].question.question_id;
            vm.QuestionList[i].correctChoice_id = values[i];
        }

        console.log(vm.QuestionList);

        return examService.verifyResult(vm.QuestionList)
            .then(function resut(response){
                vm.userDetails.score = response.data;
                delete vm.userDetails['name'];
                return loginService.resultUpdateLink(vm.userDetails)
                    .then(vm.$onInit)
                    .catch(vm.showError);
            })
            .catch(vm.showError)
            ;

    }


    function ScoreNotEmpty(){

        if(vm.userDetails.score !== null){return true;}
        else{return false;}
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }

    function redirect(){
        loginService.ClearHeaders();
        $location.search({foo:null,fo:null});
        $location.path('/');
    }

}
