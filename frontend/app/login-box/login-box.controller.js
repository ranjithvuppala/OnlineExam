function LoginBoxController(loginService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = onUserDidSubmit;
    vm.onReset = onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.username = parentControllerHasSetData ? vm.data.username : '';
        vm.password  = parentControllerHasSetData ? vm.data.password  : '';
    }

    function onUserDidSubmit(username, password) {
        var res =  loginService.verify(username, password)

            //.then(vm.createExamController.$oninit)
            console.log(res.$$state);
            //.then(onUserDidReset)

            //.catch(vm.showError);
    }


    function onUserDidReset() {
        vm.username = '';
        vm.password = '';
        vm.loginBox.$setPristine();
        vm.loginBox.$setUntouched();
    }

    function showError() {
        alert("Login Unsuccessful");
    }

}
