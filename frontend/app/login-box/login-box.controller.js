function LoginBoxController(loginService,$location) {
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
        vm.notes = [];
    }

    function onUserDidSubmit(username, password) {


        var test = function(response){
            //console.log(response.status);
            if(response.status == 200)
            {
                console.log("Ranjith Vuppala");
                    $location.path("/redirect");
            }
            else{
                console.log("Tarun Aluguri");
                vm.showError();
                vm.onReset();
            }


        };



         return loginService.verify(username, password)
            .then(test)
            .catch(test);


            //.then($location.path('/redirect'))
            //.then(vm.createExamController.$oninit)
            // .then(onUserDidReset)
             //.catch(test);
            //console.log(res.$$state);
            //console.log(res.$$state.name);
            //.then(onUserDidReset)

            //.catch(vm.showError);
            //.then(onUserDidReset);

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
