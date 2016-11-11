function ChoiceController(choiceService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editChoice = editChoice;
    vm.removeChoice = removeChoice;
    vm.submitEditedChoice = submitEditedChoice;
    vm.resetEditedChoice = resetEditedChoice;
    vm.showError = showError;

    function $onInit() {
        vm.resetEditedChoice();
    }

    function editChoice() {
        vm.isEditingChoice = true;
    }

    function removeChoice() {
        choiceService.destroy(vm.data.id)
            .then(vm.choicesController.refreshChoices);
    }

    function submitEditedChoice(choice) {
        return choiceService.update(vm.data.id, choice)
            .then(vm.choicesController.refreshChoices)
            .then(vm.resetEditedChoice)
            .catch(vm.showError);
    }

    function resetEditedChoice() {
        vm.isEditingChoice = false;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
