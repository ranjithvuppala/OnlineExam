function UserExamController($location,loginService,mailService,examService){
    var vm = this;

    vm.$onInit = $onInit;
    vm.showError = showError;
    vm.getExamList = getExamList;
    vm.getUserExamDetails = getUserExamDetails;
    vm.SelectedStatus= SelectStatus;
    vm.examName = examName;
    vm.unAssignedExamList = unAssignedExamList;
    vm.sendMail = sendMail;

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
        var obj = JSON.parse(object);
        if(obj.id!==undefined){
        return examService.examListAssignedToUser(obj.id)
            .then(function test(response){
                vm.UserExamList = response.data;
                //console.log(response.data);
                console.log(JSON.stringify(vm.UserExamList));
                vm.unAssignedExamList();
            })
            .catch(vm.showError);
        }

    }

    function showError(response) {
        alert(Object.values(response.data));
    }

    function SelectStatus(score){
        if(score===null){return 'Pending';}
        else{return 'Finished'; }
    }

    function examName(examId){
        for(var i=0;i<vm.ExamList.length;i++){
            if(vm.ExamList[i].exam_id === examId){
                return vm.ExamList[i].exam;
            }
        }
    }

    function unAssignedExamList(){
        vm.UnassignedList = [];
        console.log(JSON.stringify(vm.ExamList));
        for(var j=0,h=0;j<vm.ExamList.length;j++){
            var a = 0;
            for(var k=0; k<vm.UserExamList.length;k++){
                if(vm.ExamList[j].exam_id === vm.UserExamList[k].examId){ a++;}
            }
            if(a === 0) {
                vm.UnassignedList[h] = {exam_id: null, exam: null};
                vm.UnassignedList[h].exam_id = vm.ExamList[j].exam_id;
                vm.UnassignedList[h].exam = vm.ExamList[j].exam;
                h++;
            }
        }
        console.log(JSON.stringify(vm.UnassignedList));
    }


    function sendMail(examId,user){
        vm.SelectedExam=null;
        var usr = JSON.parse(user);
        var data = {
            userId: usr.id,
            examId: examId
        };

        return examService.assignExamToUser(data)
            .then(function tri(response){
                var userExamScore = response.data;
                console.log(JSON.stringify(vm.UserExamList));
                vm.UserExamList.push(userExamScore);
                console.log(JSON.stringify(vm.UserExamList));
                vm.unAssignedExamList();
                return mailService.sendExam(usr.username,userExamScore.id)
                    .then(function (response) {
                        if(response.data!==200){
                            alert("Mail Server down the link has been created but not delivered to User.");
                        }
                    }
                    );
            })
            .catch(vm.showError);

    }

}
