const UserRepository  = require('../repository/UserRepo');
const ProductRepository = require('../repository/ProductRepo');
class Validate{
    constructor(){
        this.userRepo = new UserRepository();
        this.productRepo = new ProductRepository();
    }

    async basicAuthen(req,res,next){
        // check for basic auth header
        if (!req.headers.authorization || req.headers.authorization.indexOf('Basic ') === -1) {
            return res.status(401).json({ message: 'Missing Authorization Header' });
        }

        const base64Credentials =  req.headers.authorization.split(' ')[1];
        const credentials = Buffer.from(base64Credentials, 'base64').toString('ascii');
        const [username, password] = credentials.split(':');

        const user = await this.userRepo.getByUsernameAndPassword({username,password});
        
        if (!user) {
            return res.status(401).json({ message: 'Invalid Authentication Credentials' });
        }
        req.logginUser = user;
        next();

    }

    async userHavePermissionOnProduct(req,res,next){
        let {id} = req.params;
        let userId = req.logginUser.id;
        let product = await this.productRepo.get(id);
        if (!product) {
            return res.status(404).json({ message: 'Unable to find product' });
        }
        if(product.user_id !== userId){
            return res.status(401).json({ message: 'Access this product is not allowed' });
        }
        next()
    }
}

module.exports = Validate;