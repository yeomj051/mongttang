import { createRPCInstance } from ".";
import { NFT_CONTRACT_ADDRESS, MTT_CONTRACT_ADDRESS, SSF_CONTRACT_ADDRESS, OWNER_PRIVATE_KEY } from "@/config";
import { ERC20_CONTRACT_ABI, NFT_CONTRACT_ABI, MTT_CONTRACT_ABI } from "@/config/ABIs";

const rpcInstance = createRPCInstance();
const mttContract = new rpcInstance.eth.Contract(MTT_CONTRACT_ABI, MTT_CONTRACT_ADDRESS);
const ssfContract = new rpcInstance.eth.Contract(ERC20_CONTRACT_ABI, SSF_CONTRACT_ADDRESS);
const nftContract = new rpcInstance.eth.Contract(NFT_CONTRACT_ABI, NFT_CONTRACT_ADDRESS);
    

async function getMTTBalance(accountAddress){
    let balance;
    try{
        balance = await mttContract.methods.balanceOf(accountAddress).call();
        console.log("mtt: "+ balance);
    } catch(error){
        console.error(error);
    }

    return balance;
}

async function getSSFBalance(accountAddress){
    let balance;
    try{
        balance = await ssfContract.methods.balanceOf(accountAddress).call();
        console.log("ssf: "+ balance);
    } catch(error){
        console.error(error);
    }

    return balance;
}

async function getNFTList(accountAddress){
    console.log("나 여기");
    let nfts;
    try{
        nfts = await nftContract.methods.getNfts(accountAddress).call();
        console.log(nfts);
        return nfts;
    } catch(error){
        console.error(error);
    }
}

async function makeNFT(toAddress, tokenURI){
    const ownerAccount = rpcInstance.eth.accounts.privateKeyToAccount(OWNER_PRIVATE_KEY);
    rpcInstance.eth.getTransactionCount(ownerAccount.address).then(async(nonce)=>{
        const functionAbi = nftContract.methods.create(toAddress, tokenURI).encodeABI();
        const gasPrice = 0;
        const gasLimit = 210000;
        const transactionObject = {
            nonce: rpcInstance.utils.toHex(nonce),
            gasPrice: rpcInstance.utils.toHex(gasPrice),
            gas: rpcInstance.utils.toHex(gasLimit),
            to: NFT_CONTRACT_ADDRESS,
            from: ownerAccount.address,
            data: functionAbi
        };

        const signedTx = await rpcInstance.eth.accounts.signTransaction(transactionObject, OWNER_PRIVATE_KEY);
        
        rpcInstance.eth.sendSignedTransaction(signedTx.rawTransaction).on('receipt', (receipt) => {
            console.log(`Transaction confirmed: ${receipt.transactionHash}`);
            console.log(`Gas used: ${receipt.gasUsed}`);
          })
          .on('error', (error) => {
            console.error(`Transaction error: ${error}`);
          });
    })
}

function buyMMT(userPrivateKey, amount){
    const ownerAccount = rpcInstance.eth.accounts.privateKeyToAccount(OWNER_PRIVATE_KEY);
    const userAccount = rpcInstance.eth.accounts.privateKeyToAccount(userPrivateKey);
    transferSSF(userPrivateKey, ownerAccount.address, amount/100).then( res =>{
        console.log(res);
        transferMTT(OWNER_PRIVATE_KEY, userAccount.address, amount)
        .then(console.log)
        .catch(console.log);
    }
    ).catch(console.log);
}


function sellMMT(userPrivateKey, amount){
    const ownerAccount = rpcInstance.eth.accounts.privateKeyToAccount(OWNER_PRIVATE_KEY);
    const userAccount = rpcInstance.eth.accounts.privateKeyToAccount(userPrivateKey);
    transferMTT(userPrivateKey, ownerAccount.address, amount).then( res =>{
        console.log(res);
        transferSSF(OWNER_PRIVATE_KEY, userAccount.address, amount)
        .then(console.log)
        .catch(console.log);
    }
    ).catch(console.log);
}

async function transferMTT(fromPrivateKey, toAddress, amount){
    const fromAccount = rpcInstance.eth.accounts.privateKeyToAccount(fromPrivateKey);
    rpcInstance.eth.getTransactionCount(fromAccount.address).then(async(nonce)=>{
        const functionAbi = mttContract.methods.transferFrom(fromAccount.address, toAddress, amount).encodeABI();
        const gasPrice = 0;
        const gasLimit = 210000;
        const transactionObject = {
            nonce: rpcInstance.utils.toHex(nonce),
            gasPrice: rpcInstance.utils.toHex(gasPrice),
            gas: rpcInstance.utils.toHex(gasLimit),
            to: MTT_CONTRACT_ADDRESS,
            from: fromAccount.address,
            data: functionAbi
        }; 

        const signedTx = await rpcInstance.eth.accounts.signTransaction(transactionObject, fromPrivateKey);

        rpcInstance.eth.sendSignedTransaction(signedTx.rawTransaction).on('receipt', (receipt) => {
            console.log(`Transaction confirmed: ${receipt.transactionHash}`);
            console.log(`Gas used: ${receipt.gasUsed}`);
          })
          .on('error', (error) => {
            console.error(`Transaction error: ${error}`);
          });
    });
}

async function transferSSF(fromPrivateKey, toAddress, amount){
    const fromAccount = rpcInstance.eth.accounts.privateKeyToAccount(fromPrivateKey);
    rpcInstance.eth.getTransactionCount(fromAccount.address).then(async(nonce)=>{
        const functionAbi = ssfContract.methods.transferFrom(fromAccount.address, toAddress, amount).encodeABI();
        const gasPrice = 0;
        const gasLimit = 210000;
        const transactionObject = {
            nonce: rpcInstance.utils.toHex(nonce),
            gasPrice: rpcInstance.utils.toHex(gasPrice),
            gas: rpcInstance.utils.toHex(gasLimit),
            to: MTT_CONTRACT_ADDRESS,
            from: fromAccount.address,
            data: functionAbi
        }; 

        const signedTx = await rpcInstance.eth.accounts.signTransaction(transactionObject, fromPrivateKey);

        rpcInstance.eth.sendSignedTransaction(signedTx.rawTransaction).on('receipt', (receipt) => {
            console.log(`Transaction confirmed: ${receipt.transactionHash}`);
            console.log(`Gas used: ${receipt.gasUsed}`);
          })
          .on('error', (error) => {
            console.error(`Transaction error: ${error}`);
          });
    });
}

export{
    getMTTBalance,
    getNFTList,
    getSSFBalance,
    makeNFT,
    buyMMT,
    sellMMT
}