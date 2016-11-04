function QuestionFormController(questionService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.question = parentControllerHasSetData ? vm.data.question : '';
        vm.firstoption  = parentControllerHasSetData ? vm.data.firstoption  : '';
        vm.secondoption = parentControllerHasSetData ? vm.data.secondoption : '';
        vm.thirdoption  = parentControllerHasSetData ? vm.data.thirdoption  : '';
        vm.fourthoption = parentControllerHasSetData ? vm.data.fourthoption : '';
        vm.correctoption  = parentControllerHasSetData ? vm.data.correctoption  : '';
    }

    function onUserDidSubmit(quest, firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        return questionService.create(quest, firstoption,secondoption,thirdoption,fourthoption,correctoption)
            .then(vm.questionsController.refreshQuestions)
            .then(onUserDidReset)
            .catch(vm.showError);
    }

    function onUserDidReset() {
        vm.question = '';
        vm.firstoption = '';
        vm.secondoption= '';
        vm.thirdoption = '';
        vm.fourthoption = '';
        vm.correctoption = '';
        vm.questionForm.$setPristine();
        vm.questionForm.$setUntouched();
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
