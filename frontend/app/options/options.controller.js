function OptionsController(optionService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshOptions = refreshOptions;
    vm.hasOptions = hasOptions;

    function $onInit() {
        vm.options = [];
        vm.refreshOptions();
    }

    function refreshOptions() {
        return optionService.list().then(function refreshedOptions(response) {
            vm.options = response.data;

        });
    }

    function hasOptions() {
        return vm.options.length > 0;
    }
}