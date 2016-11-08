function appConfig($routeProvider,$httpProvider) {

    $httpProvider.interceptors.push('loginInterceptor');
    $routeProvider
        .when('/', {template: '<login-page></login-page>'})
        .when('/info', {template: '<info></info>'})
        .when('/redirect', {template: '<questions></questions>'})
        .when('/info1', {template: '<info1></info1>'})
        .otherwise({
            redirectTo: '/'

        })
}


/*
var onlyLoggedIn = function ($location,$q,$cookies) {
    var deferred = $q.defer();
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
*/
