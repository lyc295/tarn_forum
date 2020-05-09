const gulp = require("gulp");
const clean = require('gulp-clean');

gulp.task("cleanCss", () => {
    return gulp.src(['./app/css/*'])
    .pipe(clean());
});

gulp.task("cleanJs", () => {
    return gulp.src(['./app/js/*'])
    .pipe(clean());
});

gulp.task("cleanHtml", () => {
    return gulp.src(['./app/views/*'])
    .pipe(clean());
});

gulp.task("clean", () => {
    return gulp.src(['./app/*'])
    .pipe(clean());
});