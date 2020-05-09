const gulp = require("gulp");
const rename = require("gulp-rename");
const uglify = require("gulp-uglify");
const concat = require("gulp-concat");
const gulpif = require("gulp-if");
const browserify = require("gulp-browserify");
const browserSync = require("browser-sync").create();
const scp = require("gulp-scp2");
const plumber = require("gulp-plumber");
const sourceMap = require('gulp-sourcemaps');

const isDev = process.env.npm_lifecycle_script === "gulp dev";

gulp.task("js:pages", () => {
    return gulp.src(["./dev/js/*.js"])
        .pipe(plumber({
            errorHandler: function (error) {
                console.log(error);
                this.emit('end');
            }
        }))
        .pipe(browserify({transform: ["babelify"]}))
        .pipe( sourceMap.init() )
        // .pipe(gulpif(!isDev, uglify()))
        // .pipe(uglify())
        .pipe(rename({suffix: ".min"}))
        .pipe( sourceMap.write('../maps/',{addComment: true}) )
        .pipe(gulp.dest("./app/js"))
        .pipe(browserSync.stream());
});

gulp.task("js:utils", () => {
    return gulp.src(["./assets/utils/index.js"])
    // utils相关文件会用import, export互相引用，需要用browserify的transform: ["babelify"]，故无需再用gulp-babel
        .pipe(browserify({transform: ["babelify"]}))
        .on("error", console.log)
        .pipe(gulpif(!isDev, uglify()))
        .pipe(rename({
            basename: "utils",
            extname: ".build.js"
        }))
        .pipe(gulp.dest("./assets/js/"))
        .pipe(browserSync.stream());
});