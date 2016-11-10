function OptionController(optionService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editOption = editOption;
    vm.removeOption = removeOption;
    vm.submitEditedOption = submitEditedOption;
    vm.resetEditedOption = resetEditedOption;
    vm.showError = showError;

    function $onInit() {
        vm.resetEditedOption();
    }

    function editOption() {
        vm.isEditingOption = true;
    }

    function removeOption() {
        optionService.destroy(vm.data.option_id)
            .then(vm.optionsController.refreshOptions);
    }

    function submitEditedOption(option) {
        return optionService.update(vm.data.option_id, option)
            .then(vm.optionsController.refreshOptions)
            .then(vm.resetEditedOption)
            .catch(vm.showError);
    }

    function resetEditedOption() {
        vm.isEditingOption = false;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
