const knex = require('knex')({
    client: 'mysql',
    version: '5.7',
    connection: {
      host : 'localhost',
      port : 3306,
      user : 'root',
      password : 'root@123',
      database : 'thuc_tap'
    }
});
module.exports = knex;