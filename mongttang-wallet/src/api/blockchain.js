import { createRPCInstance } from ".";
import { NFT_CONTRACT_ADDRESS, MTT_CONTRACT_ADDRESS, SSF_CONTRACT_ADDRESS, SITE_PRIVATE_KEY } from "@/config";
import { ERC20_CONTRACT_ABI, NFT_CONTRACT_ABI, MTT_CONTRACT_ABI } from "@/config/ABIs";

const rpcInstance = createRPCInstance();

async function getMTTBalance(accountAddress){
    const mttContract = new rpcInstance.eth.Contract(MTT_CONTRACT_ABI, MTT_CONTRACT_ADDRESS);
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
    const ssfContract = new rpcInstance.eth.Contract(ERC20_CONTRACT_ABI, SSF_CONTRACT_ADDRESS);
    let balance;
    try{
        balance = await ssfContract.methods.balanceOf(accountAddress).call();
        console.log("ssf: "+ balance);
    } catch(error){
        console.error(error);
    }

    return balance;
}

async function getNTFList(){
    const nftContract = new rpcInstance.eth.Contract(NFT_CONTRACT_ABI, NFT_CONTRACT_ADDRESS);
    let nfts;
    try{
        nfts = await nftContract.methods.getMyNfts().call();
    } catch(error){
        console.error(error);
    }

    return nfts;
}

async function makeNFT(toAddress, tokenURI){
    const nftContract = new rpcInstance.eth.Contract(NFT_CONTRACT_ABI, NFT_CONTRACT_ADDRESS);
    const ownerAddress = rpcInstance.eth.accounts.privateKeyToAccount(SITE_PRIVATE_KEY);
    console.log(toAddress);
    console.log(tokenURI);
    rpcInstance.eth.getTransactionCount(ownerAddress.address).then((nonce)=>{
        const functionAbi = nftContract.methods.create(toAddress, tokenURI).encodeABI();
        const gasPrice = 0;
        const gasLimit = 210000;
        console.log("안에들어옴"+toAddress);
    console.log("안에들어옴"+tokenURI);
        const transactionObject = {
            nonce: rpcInstance.utils.toHex(nonce),
            gasPrice: rpcInstance.utils.toHex(gasPrice),
            gas: rpcInstance.utils.toHex(gasLimit),
            to: NFT_CONTRACT_ADDRESS,
            from: ownerAddress.address,
            data: functionAbi
        };

        const signedTx = rpcInstance.eth.accounts.signTransaction(transactionObject, SITE_PRIVATE_KEY);
        
        rpcInstance.eth.sendSignedTransaction(signedTx.rawTransaction).on('receipt', (receipt) => {
            console.log(`Transaction confirmed: ${receipt.transactionHash}`);
            console.log(`Gas used: ${receipt.gasUsed}`);
          })
          .on('error', (error) => {
            console.error(`Transaction error: ${error}`);
          });
    })
}

export{
    getMTTBalance,
    getNTFList,
    getSSFBalance,
    makeNFT
}