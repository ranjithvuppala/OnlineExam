function LoginBoxController(loginService,$location,$cookies) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = onUserDidSubmit;
    vm.onReset = onUserDidReset;

    vm.showError = showError;
    vm.showSuccess = showSuccess;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.username = parentControllerHasSetData ? vm.data.username : '';
        vm.password  = parentControllerHasSetData ? vm.data.password  : '';
    }

    function onUserDidSubmit(username, password) {


        var test = function(response){
            //console.log(response.status);
            if(response.status == 200)
            {
                loginService.SetHeaders(username,password,response.data.role);
                $location.path("/info1");
            }
            else{

                vm.showError();
                vm.onReset();
            }


        };

         return loginService.verify(username, password)
            .then(test)
            .catch(test);

    }



    function onUserDidReset() {
        vm.username = '';
        vm.password = '';
        vm.loginBox.$setPristine();
        vm.loginBox.$setUntouched();
    }
    function showSuccess(){
        alert("Login Successful");
    }
    function showError() {
        alert("Login Unsuccessful");
    }

}
