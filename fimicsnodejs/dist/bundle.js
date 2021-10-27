(() => {
    var r, n, t = {
        572: (r, n) => {
            n.info = function (r) {
                document.writeln(r)
            }
        }, 665: (r, n) => {
            n.add = function (r, n) {
                return r + n
            }
        }
    }, o = {};

    function e(r) {
        var n = o[r];
        if (void 0 !== n) return n.exports;
        var i = o[r] = {exports: {}};
        return t[r](i, i.exports, e), i.exports
    }

    r = e(572), n = e(665), r.info("100 + 200 =" + n.add(100, 200))
})();