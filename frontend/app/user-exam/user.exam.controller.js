function UserExamController(loginService,mailService,examService){
    var vm = this;

    vm.$onInit = $onInit;
    vm.showError = showError;
    vm.getExamList = getExamList;
    vm.getUserExamDetails = getUserExamDetails;

    function $onInit(){
        return loginService.getList("user")
            .then(function getUsers(response){
                vm.UserList = response.data;
                vm.getExamList();
            })
            .catch(vm.showError);
    }

    function getExamList(){
        return examService.examList()
            .then(function examlist(response){
                vm.ExamList = response.data;
            })
            .catch(vm.showError);
    }

    function getUserExamDetails(object){
        return examService.examListAssignedToUser(object.id)
            .then(function test(response){
                vm.UserExamList = response.data;
            })
            .catch(vm.showError);

    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }

}
