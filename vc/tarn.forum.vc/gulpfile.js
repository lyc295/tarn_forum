const gulp = require("gulp");
const browserSync = require("browser-sync").create();
const { createProxyMiddleware } = require("http-proxy-middleware");
const scp = require("gulp-scp2");
const runSequence = require('run-sequence');
const GulpSSH = require('gulp-ssh');
const deployConfig = require('./gulp/deploy.config.js');
const requireDir = require('require-dir');
requireDir('./gulp');

gulp.task("reload", () => {
    browserSync.reload();
});

gulp.task("build", (done) => {
    runSequence(
        ['clean'],
        ["js:pages","js:utils","scss:login","scss:pages"],
        ['rev'],
    done);
});

gulp.task("devFun", () => {
    browserSync.init({
        server: {
            baseDir: "./",
            directory: true
        },
        port: "9123",
        startPath: "app/views/index.html",
        middleware: [
            createProxyMiddleware(["/**/**.do"], {
                target: "http://localhost:9000/",
                changeOrigin: true
            })
        ]
    });
    gulp.watch(["dev/js/*.js"], ()=>{
        runSequence(
            ['cleanJs'],
            ["js:pages"],
            ["revJs"],
            ['revHtml']
        );
    });
    gulp.watch(["dev/scss/*.scss"], ()=>{
        runSequence(
            ['cleanCss'],
            ["scss:login","scss:pages"],
            ["revCss"],
            ['revHtml']
        );
    });
    gulp.watch(["dev/views/*.html"], ()=>{
        runSequence(
            ['cleanHtml'],
            ['revHtml']
        );
    });
    gulp.watch(["app/views/*.html"], ["reload"]);
});

gulp.task("dev", (done) => {
    runSequence(
        ['clean'],
        ["js:pages","js:utils","scss:login","scss:pages"],
        ['rev'],
        ['devFun'],
    done);
});


gulp.task("default", ["help"], () => {
});
