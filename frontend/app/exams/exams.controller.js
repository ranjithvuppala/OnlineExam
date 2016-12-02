function ExamsController(questionService,examService,examQuestionService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit1 =onUserDidSubmit1;
    vm.onReset  =onUserDidReset;

    vm.transfer= transfer;
    vm.onSubmit2 = onSubmit2;
    vm.showError = showError;
    vm.submittedExamTitleNotEmpty = submittedExamTitleNotEmpty;
    vm.selectedQuestionsNotEmpty = selectedQuestionsNotEmpty;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.exam = parentControllerHasSetData ? vm.data.exam : '';
        vm.submittedExamTitle = [];
        vm.ExamQuestion = [];
        return questionService.list1()
            .then(function retrievedQuestions(response) {
                vm.left = response.data;
                vm.right = [];
                return examService.examResponseList()
                    .then(function (res) {
                        vm.ExamResponseList=res.data;
                        console.log(JSON.stringify(vm.ExamResponseList));
                    });
        });
    }

    function onUserDidSubmit1(exam) {
        if(vm.left.length!==0){
        return examService.create(exam)
            .then(function submittedExamTitle(response){

                if(response.status === 200){
                    vm.submittedExamTitle = [response.data];
                }
            })
            .catch(vm.showError);
        }
        else{
            alert("There are no Questions present to create an exam. Please create questions before creating an exam.")
        }
    }


    function onUserDidReset() {
        vm.exam = '';
        vm.examTitle.$setPristine();
        vm.examTitle.$setUntouched();
    }

    function onSubmit2(array){
        var n = array.length;

        for (i = 0; i < n; i++) {

            vm.ExamQuestion[i] = {exam_id: null, question_id: null};
            vm.ExamQuestion[i].exam_id = vm.submittedExamTitle[0].exam_id;
            vm.ExamQuestion[i].question_id = array[i].question_id;
        }
        return examQuestionService.create(vm.ExamQuestion)
            .then(vm.$onInit)
            .catch(vm.showError);
    }


    function transfer(selected, from,to){

        var n = selected.length;
        for(i=0;i<n;i++){
            var k = arrayObjectIndexOf(from,selected[i]);
            to.push(selected[i]);
            from.splice(k,1);
        }
        to.sort(function(a, b) {
            return a.question_id - b.question_id;
        });
    }

    function arrayObjectIndexOf(Array, searchTerm) {
        for(var i = 0, len = Array.length; i < len; i++) {
            if (Array[i].question_id === searchTerm.question_id) return i;
        }
        return -1;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }

    function submittedExamTitleNotEmpty() {
        return vm.submittedExamTitle.length > 0;
    }

    function selectedQuestionsNotEmpty() {
        return vm.right.length > 0;
    }
}


