function appConfig($routeProvider,$httpProvider) {

    $httpProvider.interceptors.push('loginInterceptor');
    $routeProvider
        .when('/', {template: '<login-page></login-page>'})
        .when('/info', {template: '<info></info>'})
        .when('/info1', {template: '<info1></info1>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/choices', {template: '<choices></choices>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/createExam',{template: '<exams></exams>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/createQuestion',{template: '<question></question>',resolve:{loggedIn:onlyLoggedIn}})
        .otherwise({
            redirectTo: '/'

        })
}


var onlyLoggedIn = function ($location,$q,$cookies) {
    var deferred = $q.defer();
    console.log(deferred);
    var authdata = $cookies.get('authdata')|| null;


    if (authdata!= null) {
        deferred.resolve();
    }
    else {
        deferred.reject();
        $location.url('/login');
    }
    return deferred.promise;
};


