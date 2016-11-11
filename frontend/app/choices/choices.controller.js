function ChoicesController(choiceService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshChoices = refreshChoices;
    vm.hasChoices = hasChoices;

    function $onInit() {
        vm.choices = [];
        vm.refreshChoices();
    }

    function refreshChoices() {
        return choiceService.list().then(function refreshedChoices(response) {
            vm.choices = response.data;

        });
    }

    function hasChoices() {
        return vm.choices.length > 0;
    }
}