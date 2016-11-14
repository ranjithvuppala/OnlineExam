function DualSelectController(questionService,examService){

    var vm = this;

    vm.$onInit = $onInit;
    vm.transfer= transfer;
    vm.onSubmit = onSubmit;


    function $onInit(){
        return questionService.listquestions().then(function refreshedQuestions(response) {
            vm.left = response.data;
            vm.right = [];
        })

    }

    function transfer(selected, from,to){

        var n = selected.length;
        for(i=0;i<n;i++){
            if(vm.right.length >= 5 && to == vm.right){
                alert("You cannot select more than 5 questions");
                break;
            }
            var k = arrayObjectIndexOf(from,selected[i]);
            to.push(selected[i]);
            from.splice(k,1);
        }

        to.sort(function(a, b) {
            return a.question_id - b.question_id;
        });
    }
    function arrayObjectIndexOf(Array, searchTerm) {
        for(var i = 0, len = Array.length; i < len; i++) {
            if (Array[i].question_id === searchTerm.question_id) return i;
        }
        return -1;
    }


    function onSubmit(array){

        if(array.length != 5){ alert("Please select 5 questions") }
        else{
            var data = {firstquestion_id:array[0].question_id,
                secondquestion_id:array[1].question_id,
                thirdquestion_id:array[2].question_id,
                fourthquestion_id:array[3].question_id,
                fifthquestion_id:array[4].question_id};
            return examService.create(data)
                .then($onInit)
                .catch(vm.showError);
        }

    }


    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
