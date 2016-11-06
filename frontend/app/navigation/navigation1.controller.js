function Navigation1Controller(loginService,$location){
    var vm = this;
/*    vm.$onInit = $onInit;*/
    vm.onLogout = onLogout;

/*    function $onInit(){}*/
    function onLogout(){

        loginService.ClearHeaders();
        $location.path("/");
    }

}
