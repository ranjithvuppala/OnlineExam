function QuestionsController(questionService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshQuestions = refreshQuestions;
    vm.hasQuestions = hasQuestions;

    function $onInit() {
        vm.questions = [];
        vm.refreshQuestions();
    }

    function refreshQuestions() {
        return questionService.list().then(function refreshedQuestions(response) {
            vm.questions = response.data;

        });
    }

    function hasQuestions() {
        return vm.questions.length > 0;
    }
}