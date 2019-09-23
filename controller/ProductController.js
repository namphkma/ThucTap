const ProductRepository = require('../repository/ProductRepo');

class ProductController {
    constructor() {
        this.productDao = new ProductRepository();
    }

    async getListProduct(req, res) {
        var product  = await this.productDao.getByUserId(req.logginUser.id);
        res.json(product);
    }
    async getProductById(req, res) {
        let {id} = req.params;
        var product  = await this.productDao.get(id);
        res.json(product);
    }
    async updateProduct(req,res){
        let {body} = req;
        var data = await this.productDao.update(body);
        res.json(data);        
    }
    async insertProduct(req,res){
        let {body} = req;
        body.user_id = req.logginUser.id;
        var data = await this.productDao.add(body);
        res.json(data);
    }
    async deleteProduct(req,res){
        let {id} = req.params;
        var data  = await this.productDao.del(id);
        res.json(data);
    }
}
module.exports = ProductController;