const db = require('../util/dbConfig');
class ProductRepository {
    constructor(tableName) {
        this.tableName = 'product';
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
    count() {
        return new Promise( (resolve, reject) => {
            db(this.tableName).count('id')
            .then( res => resolve(res[0]['count(`id`)']))
            .catch( err => reject(err));
        })
    }
    getByUserId(userId){
        return new Promise((resolve,reject)=>{
            db(this.tableName).where({user_id: userId})
                .then((res)=>resolve(res))
                .catch(err=> reject(err))
        })
        
    }
}
module.exports = ProductRepository