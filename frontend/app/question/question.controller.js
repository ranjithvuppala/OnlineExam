function QuestionController(questionService,questionChoiceService,choiceService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit1 =onUserDidSubmit1;
    vm.onReset  =onUserDidReset;

    vm.transfer= transfer;
    vm.onSubmit2 = onSubmit2;
    vm.showError = showError;
    vm.submittedQuestionEmpty = submittedQuestionEmpty;
    vm.selectedChoicesEmpty = selectedChoicesEmpty;
    vm.destroy = destroy;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.question = parentControllerHasSetData ? vm.data.question : '';
        vm.submittedQuestion = [];
        vm.questionWithCorrectChoice = {question_id:null,question:null,correctChoice_id:null};
        vm.QuestionChoice = [];
        vm.correctOption = null;
        return questionService.list()
            .then(function test(response) {
                vm.QuestionList = response.data;
                console.log(vm.QuestionList);
                return choiceService.list()
                    .then(function retrievedOptions(response) {
                        vm.left = response.data;
                        vm.right = [];
                    });
            })
            .catch(vm.showError);
    }

    function onUserDidSubmit1(question) {
        if(vm.left.length!==0){
        return questionService.create(question)
            .then(function submittedQuestion(response){

                if(response.status === 200){
                    vm.submittedQuestion = [response.data];
                }
            })
            .catch(vm.showError);
        }
        else{
            alert("There are no Choices present to create a question. Please enter choices before creating any question")
        }
    }


    function onUserDidReset() {
        vm.question = '';
        vm.demo.$setPristine();
        vm.demo.$setUntouched();
    }

    function onSubmit2(obj,array){

        console.log(array);
        console.log(obj);

        if(obj === null){alert("Please select correct option")}
        else {
            var n = array.length;

            for (i = 0; i < n; i++) {

                vm.QuestionChoice[i] = {question_id: null, choice_id: null};
                vm.QuestionChoice[i].question_id = vm.submittedQuestion[0].question_id;
                vm.QuestionChoice[i].choice_id = array[i].choice_id;
            }

            vm.questionWithCorrectChoice.question_id = vm.submittedQuestion[0].question_id;
            vm.questionWithCorrectChoice.question = vm.submittedQuestion[0].question;
            vm.questionWithCorrectChoice.correctChoice_id = obj.choice_id;


            return questionChoiceService.create(vm.QuestionChoice)
                .then(function test(){
                    return questionService.update(vm.questionWithCorrectChoice)
                        .then(vm.$onInit)
                        .catch(vm.showError);
                })
                .catch(vm.showError);
        }

    }


    function transfer(selected, from,to){

        var n = selected.length;
        for(i=0;i<n;i++){
            var k = arrayObjectIndexOf(from,selected[i]);
            to.push(selected[i]);
            from.splice(k,1);
        }
        to.sort(function(a, b) {
            return a.choice_id - b.choice_id;
        });
    }

    function arrayObjectIndexOf(Array, searchTerm) {
        for(var i = 0, len = Array.length; i < len; i++) {
            if (Array[i].choice_id === searchTerm.choice_id) return i;
        }
        return -1;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }

    function submittedQuestionEmpty() {
        return vm.submittedQuestion.length > 0;
    }

    function selectedChoicesEmpty() {
        return vm.right.length > 0;
    }


    function destroy(id){
        return questionService.destroy(id)
            .then(vm.$onInit)
            .catch(vm.showError);
    }

}

