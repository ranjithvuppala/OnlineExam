angular.module('app', ['ngRoute','ngCookies'])
    .factory('loginService',loginService)
    .factory('loginInterceptor', loginInterceptor)
    .factory('examService', examService)
    .component('loginBox', {
        templateUrl: 'app/login-box/login-box.html',
        controller: LoginBoxController,
        controllerAs: 'vm',


        bindings: {
            data: '<',
            onSubmit: '<'

        }

    })

    //.......................................................................
    .factory('questionService', questionService )
    .component('questionForm', {
        templateUrl: 'app/question-form/question-form.html',
        controller: QuestionFormController,
        controllerAs: 'vm',

        require: {
            questionsController: '^?questions'
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


    //........................................................................

    .factory('choiceService', choiceService )
    .component('choiceForm', {
        templateUrl: 'app/choice-form/choice-form.html',
        controller: ChoiceFormController,
        controllerAs: 'vm',

        require: {
            choicesController: '^?choices'
        },

        bindings: {
            data: '<',
            onSubmit: '<',
            onReset: '<'
        }
    })
    .component('choice', {
        templateUrl: 'app/choice/choice.html',
        controller: ChoiceController,
        controllerAs: 'vm',

        require: {
            choicesController: '^choices'
        },

        bindings: {
            data: '<'
        }

    })
    .component('choices', {
        templateUrl: 'app/choices/choices.html',
        controller: ChoicesController,
        controllerAs: 'vm'

    })


    //...........................................................................



    .component('navigation1', {
        templateUrl: 'app/navigation/navigation1.html',
        controller: Navigation1Controller,
        controllerAs: 'vm'
    })
    .component('info1', { templateUrl: 'app/info/info1.html' })



    //.................................................................

    .component('loginPage', {templateUrl: 'app/login-page/login-page.html' })
    .component('navigation', { templateUrl: 'app/navigation/navigation.html' })
    .component('info', { templateUrl: 'app/info/info.html' })
    .component('dualSelect',{
        templateUrl: 'app/dual-select/dual-select.html',
        controller : DualSelectController,
        controllerAs : 'vm'
    })
    .component('demo',{
            templateUrl: 'app/demo/demo.html',
            controller : DemoController,
            controllerAs : 'vm'
    })

    .component('exams',{templateUrl: 'app/exams/exams.html'})

    .config(appConfig)
    .run(run);

function run($http,$cookies){

    var authdata = $cookies.get('authdata')|| null;

    if (authdata!= null){
        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
    }
}