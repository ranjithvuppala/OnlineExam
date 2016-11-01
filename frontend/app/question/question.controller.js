function QuestionController(questionService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editQuestion = editQuestion;
    vm.removeQuestion = removeQuestion;
    vm.submitEditedQuestion = submitEditedQuestion;
    vm.resetEditedQuestion = resetEditedQuestion;
    vm.showError = showError;

    function $onInit() {
        // vm.notesController will be our parent controller (NotesController)
        // vm.data will contain the data of this note
        vm.resetEditedQuestion();
    }

    function editQuestion() {
        vm.isEditingQuestion = true;
    }

    function removeQuestion() {
        questionService.destroy(vm.data.id)
            .then(vm.questionsController.refreshQuestions);
    }

    function submitEditedQuestion(quest, firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        return questionService.update(vm.data.id, quest, firstoption,secondoption,thirdoption,fourthoption,correctoption)
            .then(vm.questionsController.refreshQuestions)
            .then(vm.resetEditedQuestion)
            .catch(vm.showError);
    }

    function resetEditedQuestion() {
        vm.isEditingQuestion = false;
    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}
