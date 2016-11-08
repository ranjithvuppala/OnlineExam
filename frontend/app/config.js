function appConfig($routeProvider,$httpProvider) {


        console.log("sdzgdrh");
    $routeProvider
        .when('/', {template: '<login-page></login-page>'})
        .when('/info', {template: '<info></info>'})
        .when('/redirect', {template: '<questions></questions>',resolve:{loggedIn:onlyLoggedIn}})
        .when('/info1', {template: '<info1></info1>',resolve:{loggedIn:onlyLoggedIn}})
        .otherwise({
            redirectTo: '/'
        })
    $httpProvider.interceptors.push('loginInterceptor');
}


var onlyLoggedIn = function ($location,$q,$cookies) {
    var deferred = $q.defer();
    var authdata = $cookies.get('authdata')|| null;


    if (authdata!= null) {
        deferred.resolve();
    } else {
        deferred.reject();
        $location.url('/login');
    }
    return deferred.promise;
};