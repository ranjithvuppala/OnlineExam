function Navigation1Controller(loginService,$location,$cookies){
    var vm = this;
    vm.$onInit = $onInit;
    vm.onLogout = onLogout;
    vm.UserIsAdmin = UserIsAdmin;

    function $onInit(){
        vm.User = $cookies.get('username');
    }
    function onLogout(){
        loginService.ClearHeaders();
        $location.path("/");
    }

    function UserIsAdmin(){
        var role = $cookies.get('role');
        if(role==='adm'){return true}
        else{return false}
    }

}
