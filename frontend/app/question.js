angular.module('question', ['ngRoute'])
.factory('questionService', questionService )
    .component('questionForm', {
        templateUrl: 'app/question-form/question-form.html',
        controller: QuestionFormController,
        controllerAs: 'vm',

        require: {
            questionsController: '^questions'
        },

        bindings: {
            data: '<',
            onSubmit: '<',
            onReset: '<'
        }
    })
    .component('question', {
        templateUrl: 'app/question/question.html',
        controller: QuestionController,
        controllerAs: 'vm',

        require: {
            questionsController: '^questions'
        },

        bindings: {
            data: '<'
        }

    })
    .component('questions', {
        templateUrl: 'app/questions/questions.html',
        controller: QuestionsController,
        controllerAs: 'vm'
    })
    .component('navigation1', { templateUrl: 'app/navigation/navigation1.html' })
    .component('info1', { templateUrl: 'app/info/info1.html' })

    .config(questionConfig)




