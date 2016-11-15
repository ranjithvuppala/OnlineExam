function loginInterceptor($location) {
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

    function authRedirect(config,response){
        if(response.status === 401|| response.status === 403)
        {
            $location.url('/login');
            return response;
        }
        return response;

    }
}

