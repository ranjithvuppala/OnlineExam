angular.module('app', ['ngRoute'])
    .factory('loginService',loginService)
    .component('loginBox', {
        templateUrl: 'app/login-box/login-box.html',
        controller: LoginBoxController,
        controllerAs: 'vm',
        bindings: {
            data: '<',
            onSubmit: '<'

        },
        require: {
            CreateExamController: '^?createExam'
        }
    })

    .component('createExam', {
        templateUrl: 'app/create-exam/create-exam.html',
        controller: CreateExamController,
        controllerAs: 'vm'
    })


    .component('loginPage', {templateUrl: 'app/login-page/login-page.html' })
    .component('navigation', { templateUrl: 'app/navigation/navigation.html' })
    .component('info', { templateUrl: 'app/info/info.html' })

    .config(appConfig);