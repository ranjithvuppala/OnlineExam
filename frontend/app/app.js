angular.module('app', ['ngRoute','ngCookies'])
    .factory('loginService',loginService)
    .factory('loginInterceptor', loginInterceptor)
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

    .config(appConfig)
    .run(run);

function run($http,$cookies){

    var authdata = $cookies.get('authdata')|| null;

    if (authdata!= null){
        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
    }
}