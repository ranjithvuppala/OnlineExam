function appConfig($routeProvider,$httpProvider) {

    $httpProvider.interceptors.push('loginInterceptor');
    $routeProvider
        .when('/login', {template: '<login-page></login-page>'})
        .when('/', {template: '<info></info>'})
        .when('/info1', {template: '<info1></info1>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/choices', {template: '<choices></choices>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/createExam',{template: '<exams></exams>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/createQuestion',{template: '<question></question>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/examDisplay',{template:'<exam-display></exam-display>'})
        .when('/UserMaintenance',{template:'<user-maintenance></user-maintenance>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/UserExam',{template:'<user-exam></user-exam>',resolve:{loggedIn:onlyLoggedIn}})
        .otherwise({
            redirectTo: '/'

        })
}


var onlyLoggedIn = function ($location,$q,$cookies) {
    var deferred = $q.defer();
    var authdata = $cookies.get('authdata')|| null;
    var role = $cookies.get('role')|| null;


    if (role === "adm") {
        deferred.resolve();
    }
    else {
        deferred.reject();
        $location.url('/login');
    }
    return deferred.promise;
};


