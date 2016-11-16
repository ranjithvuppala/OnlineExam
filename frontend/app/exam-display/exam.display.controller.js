function ExamDisplayController(examService){

    var vm = this;
    vm.$onInit = $onInit;
    vm.getExambyId = getExambyId;

    function $onInit(){
        vm.getExambyId();
    }

    function getExambyId(){
        return examService.display(1)
            .then(function getExam(response){
                vm.getExam = response.data;
                console.log(vm.getExam);
            })
    }

}
