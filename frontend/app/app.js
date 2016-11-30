angular.module('app', ['ngRoute','ngCookies'])
    .factory('loginService',loginService)
    .factory('loginInterceptor', loginInterceptor)
    .factory('questionChoiceService', questionChoiceService)
    .factory('examService', examService)
    .factory('examQuestionService', examQuestionService)
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
    .factory('mailService', mailService )
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
    .component('question',{
            templateUrl: 'app/question/question.html',
            controller : QuestionController,
            controllerAs : 'vm'
    })
    .component('userMaintenance',{
            templateUrl: 'app/user-maintenance/user-maintenance.html',
            controller : UserMaintenanceController,
            controllerAs : 'vm'
    })
    .component('userExam',{
        templateUrl: 'app/user-exam/user-exam.html',
        controller : UserExamController,
        controllerAs : 'vm'
    })

    .component('exams',{
        templateUrl: 'app/exams/exams.html',
        controller: ExamsController,
        controllerAs: 'vm'
    })

    .component('examDisplay',{
        templateUrl: 'app/exam-display/exam-display.html',
        controller: ExamDisplayController,
        controllerAs: 'vm'
    })

    .config(appConfig)
    .run(run);

function run($http,$cookies){
    var authdata = $cookies.get('authdata')|| null;

    if (authdata!= null){
        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
    }
}