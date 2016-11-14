
function choiceService($http, $interpolate) {
    var choice1 = $interpolate('/api/Choice/{{choice_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(choice1());
    }

    function create(choice) {
        var data = {
            choice:choice
        };

        return $http.post(choice1(), data);
    }

    function destroy(choice_id) {
        return $http.delete(choice1({ choice_id: choice_id }));
    }

    function update(choice_id,choice) {
        var data = {
            choice:choice
        };

        return $http.put(choice1({ choice_id: choice_id }), data);
    }
}
