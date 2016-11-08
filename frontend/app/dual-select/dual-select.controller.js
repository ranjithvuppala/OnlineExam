function DualSelectController(questionService){

    var vm = this;

    vm.$onInit = $onInit;
    vm.transfer = transfer;


    function $onInit(){
        return questionService.listquestions().then(function refreshedQuestions(response) {
            vm.left = response.data;
            vm.right = [];
        })

    }

    function transfer(selected, from,to){


    }
}
