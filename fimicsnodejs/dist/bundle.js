(() => {
    var e, t, r = {
        182: (e, t, r) => {
            "use strict";
            r.d(t, {Z: () => s});
            var n = r(81), o = r.n(n), a = r(645), i = r.n(a)()(o());
            i.push([e.id, "body{\n    background-color: blue;\n}", ""]);
            const s = i
        }, 645: e => {
            "use strict";
            e.exports = function (e) {
                var t = [];
                return t.toString = function () {
                    return this.map((function (t) {
                        var r = "", n = void 0 !== t[5];
                        return t[4] && (r += "@supports (".concat(t[4], ") {")), t[2] && (r += "@media ".concat(t[2], " {")), n && (r += "@layer".concat(t[5].length > 0 ? " ".concat(t[5]) : "", " {")), r += e(t), n && (r += "}"), t[2] && (r += "}"), t[4] && (r += "}"), r
                    })).join("")
                }, t.i = function (e, r, n, o, a) {
                    "string" == typeof e && (e = [[null, e, void 0]]);
                    var i = {};
                    if (n) for (var s = 0; s < this.length; s++) {
                        var c = this[s][0];
                        null != c && (i[c] = !0)
                    }
                    for (var u = 0; u < e.length; u++) {
                        var l = [].concat(e[u]);
                        n && i[l[0]] || (void 0 !== a && (void 0 === l[5] || (l[1] = "@layer".concat(l[5].length > 0 ? " ".concat(l[5]) : "", " {").concat(l[1], "}")), l[5] = a), r && (l[2] ? (l[1] = "@media ".concat(l[2], " {").concat(l[1], "}"), l[2] = r) : l[2] = r), o && (l[4] ? (l[1] = "@supports (".concat(l[4], ") {").concat(l[1], "}"), l[4] = o) : l[4] = "".concat(o)), t.push(l))
                    }
                }, t
            }
        }, 81: e => {
            "use strict";
            e.exports = function (e) {
                return e[1]
            }
        }, 87: (e, t, r) => {
            "use strict";
            r.r(t), r.d(t, {default: () => h});
            var n = r(379), o = r.n(n), a = r(795), i = r.n(a), s = r(569), c = r.n(s), u = r(565), l = r.n(u),
                d = r(216), p = r.n(d), f = r(589), v = r.n(f), m = r(182), y = {};
            y.styleTagTransform = v(), y.setAttributes = l(), y.insert = c().bind(null, "head"), y.domAPI = i(), y.insertStyleElement = p(), o()(m.Z, y);
            const h = m.Z && m.Z.locals ? m.Z.locals : void 0
        }, 379: e => {
            "use strict";
            var t = [];

            function r(e) {
                for (var r = -1, n = 0; n < t.length; n++) if (t[n].identifier === e) {
                    r = n;
                    break
                }
                return r
            }

            function n(e, n) {
                for (var a = {}, i = [], s = 0; s < e.length; s++) {
                    var c = e[s], u = n.base ? c[0] + n.base : c[0], l = a[u] || 0, d = "".concat(u, " ").concat(l);
                    a[u] = l + 1;
                    var p = r(d), f = {css: c[1], media: c[2], sourceMap: c[3], supports: c[4], layer: c[5]};
                    if (-1 !== p) t[p].references++, t[p].updater(f); else {
                        var v = o(f, n);
                        n.byIndex = s, t.splice(s, 0, {identifier: d, updater: v, references: 1})
                    }
                    i.push(d)
                }
                return i
            }

            function o(e, t) {
                var r = t.domAPI(t);
                return r.update(e), function (t) {
                    if (t) {
                        if (t.css === e.css && t.media === e.media && t.sourceMap === e.sourceMap && t.supports === e.supports && t.layer === e.layer) return;
                        r.update(e = t)
                    } else r.remove()
                }
            }

            e.exports = function (e, o) {
                var a = n(e = e || [], o = o || {});
                return function (e) {
                    e = e || [];
                    for (var i = 0; i < a.length; i++) {
                        var s = r(a[i]);
                        t[s].references--
                    }
                    for (var c = n(e, o), u = 0; u < a.length; u++) {
                        var l = r(a[u]);
                        0 === t[l].references && (t[l].updater(), t.splice(l, 1))
                    }
                    a = c
                }
            }
        }, 569: e => {
            "use strict";
            var t = {};
            e.exports = function (e, r) {
                var n = function (e) {
                    if (void 0 === t[e]) {
                        var r = document.querySelector(e);
                        if (window.HTMLIFrameElement && r instanceof window.HTMLIFrameElement) try {
                            r = r.contentDocument.head
                        } catch (e) {
                            r = null
                        }
                        t[e] = r
                    }
                    return t[e]
                }(e);
                if (!n) throw new Error("Couldn't find a style target. This probably means that the value for the 'insert' parameter is invalid.");
                n.appendChild(r)
            }
        }, 216: e => {
            "use strict";
            e.exports = function (e) {
                var t = document.createElement("style");
                return e.setAttributes(t, e.attributes), e.insert(t, e.options), t
            }
        }, 565: (e, t, r) => {
            "use strict";
            e.exports = function (e) {
                var t = r.nc;
                t && e.setAttribute("nonce", t)
            }
        }, 795: e => {
            "use strict";
            e.exports = function (e) {
                var t = e.insertStyleElement(e);
                return {
                    update: function (r) {
                        !function (e, t, r) {
                            var n = "";
                            r.supports && (n += "@supports (".concat(r.supports, ") {")), r.media && (n += "@media ".concat(r.media, " {"));
                            var o = void 0 !== r.layer;
                            o && (n += "@layer".concat(r.layer.length > 0 ? " ".concat(r.layer) : "", " {")), n += r.css, o && (n += "}"), r.media && (n += "}"), r.supports && (n += "}");
                            var a = r.sourceMap;
                            a && "undefined" != typeof btoa && (n += "\n/*# sourceMappingURL=data:application/json;base64,".concat(btoa(unescape(encodeURIComponent(JSON.stringify(a)))), " */")), t.styleTagTransform(n, e, t.options)
                        }(t, e, r)
                    }, remove: function () {
                        !function (e) {
                            if (null === e.parentNode) return !1;
                            e.parentNode.removeChild(e)
                        }(t)
                    }
                }
            }
        }, 589: e => {
            "use strict";
            e.exports = function (e, t) {
                if (t.styleSheet) t.styleSheet.cssText = e; else {
                    for (; t.firstChild;) t.removeChild(t.firstChild);
                    t.appendChild(document.createTextNode(e))
                }
            }
        }, 572: (e, t) => {
            t.info = function (e) {
                document.writeln(e)
            }
        }, 665: (e, t) => {
            t.add = function (e, t) {
                return e + t
            }
        }
    }, n = {};

    function o(e) {
        var t = n[e];
        if (void 0 !== t) return t.exports;
        var a = n[e] = {id: e, exports: {}};
        return r[e](a, a.exports, o), a.exports
    }

    o.n = e => {
        var t = e && e.__esModule ? () => e.default : () => e;
        return o.d(t, {a: t}), t
    }, o.d = (e, t) => {
        for (var r in t) o.o(t, r) && !o.o(e, r) && Object.defineProperty(e, r, {enumerable: !0, get: t[r]})
    }, o.o = (e, t) => Object.prototype.hasOwnProperty.call(e, t), o.r = e => {
        "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(e, "__esModule", {value: !0})
    }, e = o(572), t = o(665), o(87), e.info("100 + 200 =" + t.add(100, 200))
})();