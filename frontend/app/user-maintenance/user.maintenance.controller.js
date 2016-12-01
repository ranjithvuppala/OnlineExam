function UserMaintenanceController(loginService,mailService){
    var vm = this;

    vm.$onInit = $onInit;
    vm.addUser = addUser;
    vm.showError = showError;
    vm.getAdminList = getAdminList;
    vm.UserListNotEmpty = UserListNotEmpty;
    vm.AdminListNotEmpty = AdminListNotEmpty;
    vm.sendDetails = sendDetails;

    function $onInit(){
        vm.user={};
        return loginService.getList("user")
            .then(function getUsers(response){
                vm.UserList = response.data;
                vm.getAdminList();
            })
            .catch(vm.showError);

    }

    function getAdminList(){
        return loginService.getList("adm")
            .then(function getAdmins(response){
                vm.AdminList=response.data;

            })
            .catch(vm.showError);
    }

    function addUser(user,rights) {
        if (rights !== true) {
            var role = "user";
            return loginService.addUser(user.user, user.user, role)
                .then(vm.$onInit)
                .catch(vm.showError);
        }
        else
        {
            role = "adm";
            return loginService.addUser(user.user, user.password, role)
                .then(vm.sendDetails(user.user, user.password))
                .then(vm.$onInit)
                .catch(vm.showError);

        }
    }

    function showError(response){
        alert(response.data.errors.join("\n"));
    }


    function UserListNotEmpty(){
       return vm.UserList.length > 0;
    }

    function AdminListNotEmpty(){
         return vm.AdminList.length > 0;
    }

    function sendDetails(user,password){
         return mailService.sendDetails(user,password)
            .then(alert("Login Details has been send to user successfully"))
            .catch(vm.showError);
    }

}