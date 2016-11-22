function questionService($http, $interpolate) {
    var question = $interpolate('/api/QuestionPaper/{{question_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update,
        list1: list1
    };

    function list() {
        return $http.get(question());
    }

    function list1(){
        return $http.get('/api/QuestionPaper/all');
    }

    function create(quest) {
        var data = {
            question: quest
        };

        return $http.post(question(), data);
    }

    function destroy(question_id) {
        return $http.delete(question({ question_id: question_id }));
    }

    function update(obj) {

        id = obj.question_id;
        return $http.put(question({ question_id: id }), obj);
    }
}
