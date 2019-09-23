var express = require('express');
var bodyParser = require('body-parser')
const Validate = require('./util/validate');
const validate = new Validate();
var app = express();

const ApiRouter = require('./routes/Product');

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.use('/api',validate.basicAuthen.bind(validate), ApiRouter);

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})