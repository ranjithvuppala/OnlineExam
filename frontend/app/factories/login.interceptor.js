function loginInterceptor($location,$q) {
    return {
        request: function(config) {
            return config;
        },

        requestError: authRedirect ,

        response: function(res) {
            return res;
        },

        responseError: authRedirect

    };

    function authRedirect(response){
        if(response.status === 401|| response.status === 403)
        {
            $location.url('/login');
            return $q.reject(response);
        }
        else {
            return $q.reject(response);
        }
    }
}

