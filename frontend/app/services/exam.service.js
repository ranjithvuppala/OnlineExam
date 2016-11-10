function examService($http,$interpolate) {
    var userdata = $interpolate('/api/ExamProcess/');

    return {
        create: create
    };


    function create(data) {
        return $http.post(userdata(), data);
    }


}
