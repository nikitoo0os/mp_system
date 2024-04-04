interface IContractorResponse {
    id: number;
    name: string;
    type: string;
    description: string;
    email: string;
    actualAddress: string;
    isActive: boolean;
    createdAt: string;
    phoneNum: string;
    paymentNum: string;
}

export default IContractorResponse;