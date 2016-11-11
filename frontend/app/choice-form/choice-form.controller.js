function ChoiceFormController(choiceService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.choice = parentControllerHasSetData ? vm.data.choice : '';
    }

    function onUserDidSubmit(choice) {
        return choiceService.create(choice)
            .then(vm.choicesController.refreshChoices)
            .then(onUserDidReset)
            .catch(vm.showError);
    }

    function onUserDidReset() {
        vm.choice = '';
        vm.choiceForm.$setPristine();
        vm.choiceForm.$setUntouched();
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
