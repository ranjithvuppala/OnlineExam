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
        console.log(vm.data);
        choiceService.destroy(vm.data.choice_id)
            .then(vm.choicesController.refreshChoices);
    }

    function submitEditedChoice(choice) {
        console.log(vm.data);
        return choiceService.update(vm.data.choice_id, choice)
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
