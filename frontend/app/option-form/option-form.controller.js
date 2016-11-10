function OptionFormController(optionService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.option = parentControllerHasSetData ? vm.data.option : '';
    }

    function onUserDidSubmit(option) {
        return optionService.create(option)
            .then(vm.optionsController.refreshOptions)
            .then(onUserDidReset)
            .catch(vm.showError);
    }

    function onUserDidReset() {
        vm.option = '';
        vm.optionForm.$setPristine();
        vm.optionForm.$setUntouched();
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
