function DemoController(questionService,choiceService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit1 =onUserDidSubmit1;
    vm.onReset  =onUserDidReset;

    vm.transfer= transfer;
   /* vm.onSubmit2 = onSubmit2;
*/
    vm.showError = showError;
    vm.submittedQuestionEmpty = submittedQuestionEmpty;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.question = parentControllerHasSetData ? vm.data.question : '';
        vm.submittedQuestion = [];
        return choiceService.list().then(function retrievedOptions(response) {
            vm.left = response.data;
            vm.right = [];
        });

    }

    function onUserDidSubmit1(question) {
        return questionService.create(question)
            .then(function submittedQuestion(response){

                if(response.status === 200){
                    vm.submittedQuestion = [response.data];
                }

                //vm.onReset();

            })
            .catch(vm.showError);
    }


    function onUserDidReset() {
        vm.question = '';
        vm.demo.$setPristine();
        vm.demo.$setUntouched();
    }
/*
    function onSubmit2(array){

            var data = {
                    question_id:question_id,
                    choice_id:array[i].choice_id
                };
            return examService.create(data)
                .then($onInit)
                .catch(vm.showError);


    }
*/

    function transfer(selected, from,to){

        var n = selected.length;
        for(i=0;i<n;i++){
            if(vm.right.length >= 5 && to == vm.right){
                alert("You cannot select more than 5 questions");
                break;
            }
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
        console.log(vm.submittedQuestion);
        return vm.submittedQuestion.length > 0;
    }
}

