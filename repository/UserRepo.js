const db = require('../util/dbConfig');
class ProductRepository {
    constructor(tableName) {
        this.tableName = 'users';
    }
    get(id) {
        return new Promise( (resolve, reject) => {
            db(this.tableName).where({id}).select('*')
            .then( res => resolve(res[0]))
            .catch( err => reject(err));
        })
    }
    getAll() {
        return new Promise( (resolve, reject) => {
            db(this.tableName).select('*')
            .then( res => resolve(res))
            .catch( err => reject(err));
        })
    }
    add(data) {
        return new Promise( (resolve, reject) => {
            db(this.tableName).returning('id').insert(data)
            .then( res => resolve(res))
            .catch( err => reject(err));
        })
    }
    update(data) {
        return new Promise( (resolve, reject) => {
            db(this.tableName).where({id: data.id}).update(data)
            .then( res => resolve(res))
            .catch( err => reject(err));
        })
    }
    del(id) {
        return new Promise( (resolve, reject) => {
            db(this.tableName).where({id: id}).del()
            .then( res => resolve(res))
            .catch( err => reject(err));
        })
    }
    getByUsernameAndPassword(user){
        return new Promise((resolve,reject)=>{
            db(this.tableName).where({
                username:user.username,
                password:user.password
            })
            .then( res => resolve(res[0]))
            .catch( err => reject(err))

        })
    }
}
module.exports = ProductRepository