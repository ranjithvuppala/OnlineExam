function questionService($http, $interpolate) {
    var question = $interpolate('/api/QuestionPaper/{{question_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(question());
    }

    function create(quest, firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        var data = {
            question: quest,
            firstoption: firstoption,
            secondoption: secondoption,
            thirdoption: thirdoption,
            fourthoption: fourthoption,
            correctoption: correctoption
        };

        return $http.post(question(), data);
    }

    function destroy(question_id) {
        return $http.delete(question({ question_id: question_id }));
    }

    function update(id,quest,firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        var data = {
            question: quest,
            firstoption: firstoption,
            secondoption: secondoption,
            thirdoption: thirdoption,
            fourthoption: fourthoption,
            correctoption: correctoption
        };

        return $http.put(question({ question_id: id }), data);
    }
}
