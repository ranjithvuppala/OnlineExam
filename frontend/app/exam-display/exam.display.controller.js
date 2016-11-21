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
        var test2 = $location.hash();
        vm.QuestionList=[];
        loginService.SetHeaders(test.foo,test.fo);
        return loginService.verifyLink(test.foo,test.fo)
            .then(function test(response){
                vm.userDetails = response.data;
                return examService.findExambyId(test2)
                    .then(function test1(response){
                        vm.examDetails = response.data;
                        console.log(vm.examDetails);
                        console.log(vm.userDetails);
                        if(vm.userDetails.id === vm.examDetails.userId){
                            console.log(vm.examDetails);
                            var test3 = vm.examDetails.examId;
                        }
                        else{
                            alert("The exam is not assigned for this User please exit");
                        }
                        vm.getExambyId(test3);
                    });
            });
    }

    function getExambyId(test3){
        return examService.display(test3)
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
            .then(function result(response){
                vm.examDetails.score = response.data;
                return examService.resultUpdate(vm.examDetails)
                    .then(vm.$onInit)
                    .catch(vm.showError);
            })
            .catch(vm.showError)
            ;

    }


    function ScoreNotEmpty(){

        if(vm.examDetails.score !== null){return true;}
        else{return false;}
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }

    function redirect(){
        loginService.ClearHeaders();
        $location.search({foo:null,fo:null});
        $location.hash(null);
        $location.path('/');
    }

}
